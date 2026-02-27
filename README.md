# TCP Chat Client

This repository contains a Java-based TCP client application developed for laboratory exercises in
the **Network Programming Course** at **UTM (Technical University of Moldova)**. The project focuses on
the practical implementation of TCP-based client-server communication from the client side, enabling
real-time message exchange with a multi-threaded TCP chat server. The implementation demonstrates
socket communication, concurrent message handling (sending and receiving), and graceful client shutdown
mechanisms.

## Core Functionality

- TCP Client Initialization: creating a client socket and connecting to the server.
- Username Registration: sending a username to the server upon connection.
- Real-Time Messaging: sending user messages to the server.
- Message Reception: continuously receiving and displaying broadcasted messages from the server.
- Graceful Disconnection: handling user exit commands and properly closing resources.

## Concurrency and Communication

- Dual-thread architecture:
    - Main thread handles user input and outgoing messages.
    - Separate reader thread listens for incoming server messages.
- Continuous listening for server responses while allowing simultaneous message sending.
- Safe shutdown mechanism using a shared control flag.
- Proper exception handling for network interruptions.

## Client Lifecycle Management

- Connects to server at **127.0.0.1:65433**.
- Sends username immediately after establishing the connection.
- Runs continuously until the user types `exit`.
- Closes socket and input/output streams safely.
- Waits for reader thread to terminate before application shutdown.

## Technical Architecture

- The client connects to port **65433** using Java `Socket`.
- Input/Output communication is handled through `BufferedReader` and `PrintWriter`.
- A dedicated thread continuously reads messages from the server.
- A shared boolean flag controls thread execution.
- Proper exception handling is implemented for network and I/O failures.

## Installation

1. **Clone the repository**

```bash
  git clone https://github.com/Constantin-Stamate/chat-tcp-client
```

2. **Navigate to the project folder**

```bash
  cd chat-tcp-client
```

3. **Build the project using Maven**

```bash
   mvn clean install
```

4. **Run the client**

```bash
   java -cp target/classes org.tcpchat.client.Client
```

## Resources

For guidance and references on TCP networking and concurrent server development, you can check:

- [Transmission Control Protocol (TCP)](https://en.wikipedia.org/wiki/Transmission_Control_Protocol) — for understanding
  reliable client-server communication.
- [Java Socket Programming (Oracle Tutorial)](https://docs.oracle.com/javase/tutorial/networking/sockets/) — for
  implementing TCP communication in Java.
- [Multithreading in Java](https://docs.oracle.com/javase/tutorial/essential/concurrency/) — for understanding
  thread-based concurrency and synchronization.

## Technologies

- Programming Language: Java
- Editor/IDE: IntelliJ IDEA

## Author

This project was developed as part of the **Network Programming Course** at **UTM (Technical University of Moldova)**,
where TCP socket communication, multi-threaded server design, and client-server architecture were studied and
implemented.

- GitHub: [Constantin-Stamate](https://github.com/Constantin-Stamate)
- Email: constantinstamate.r@gmail.com