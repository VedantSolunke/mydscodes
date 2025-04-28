import datetime
import socket
import threading
import time
from dateutil import parser


def startSendingTime(slave_client):
    while True:
        slave_client.send(str(datetime.datetime.now()).encode())
        print("Recent time sent successfully", end="\n\n")
        time.sleep(5)

def startReceivingTime(slave_client):
    while True:
        sync_time = parser.parse(slave_client.recv(1024).decode())
        print("Synchronized time at client is : " + str(sync_time), end="\n\n")


def initiateSlaveClient(port=8080):
    slave_client = socket.socket()
    slave_client.connect(('127.0.0.1', port))

    print("Starting to receive time from server\n")

    threading.Thread(
        target=startSendingTime,
        args=(slave_client,)
    ).start()

    threading.Thread(
        target=startReceivingTime,
        args=(slave_client,)
    ).start()


if __name__ == "__main__":
    initiateSlaveClient(port=8080)