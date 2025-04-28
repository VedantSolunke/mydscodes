import datetime
import time
import socket
import threading
from dateutil import parser



client_data = {}


def startReceivingClockTime(connector, address):
    while True:
        clock_time_string = connector.recv(1024).decode()
        clock_time = parser.parse(clock_time_string)
        clock_time_diff = datetime.datetime.now() - clock_time
        client_data[address] ={
            "clock_time": clock_time,
            "time_difference" : clock_time_diff,
            "connector": connector
        }
        print("Client Data updated with : " + str(address) ,end="\n\n")
        time.sleep(5)


def startConnecting(master_server):
    while True:
        master_slave_connector, addr = master_server.accept()
        slave_addresss = str(addr[0]) + ":" + str(addr[1])
        print(slave_addresss + " got connected Successfully")
        
        current_thread = threading.Thread(
            target=startReceivingClockTime,
            args=(master_slave_connector, slave_addresss)
        )
        current_thread.start()

def getAverageClockDiff():
    diffs = [c["time_difference"] for c in client_data.values()]
    total = sum(diffs, datetime.timedelta(0))
    return total/len(client_data)


def synchronizeAllClock():
    while True:
        print("New synchronization cycle started.")
        print("No. of clients to be synchronized : ", len(client_data))

        if client_data:
            avg_diff = getAverageClockDiff()
            for addr, client in client_data.items():
                try:
                    sync_time = datetime.datetime.now() + avg_diff
                    client["connector"].send(str(sync_time).encode())
                except:
                    print("Error sending to", addr)
        else:
            print("No client data, Synchronization not applicable.")
        print("\n\n")
        time.sleep(5)


def initiateClockServer(port=8080):
    master_server = socket.socket()
    master_server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1 )
    print("Socket at master node created successfully\n")

    master_server.bind(('', port))
    master_server.listen(10)
    print("Clock server started... \n")
    print("Starting to make connections... \n")

    master_thread = threading.Thread(
        target=startConnecting,
        args=(master_server, )
    )
    master_thread.start()

    sync_thread = threading.Thread(
        target=synchronizeAllClock,
    )
    sync_thread.start()


if __name__ == '__main__':
    initiateClockServer(port=8080)