**Name:** Mohammed BOURI
**Email address:** mohammed.bouri@um6p.ma  

## **Cloud Programming Project**  
-----------

### Overview
- This file is intended to help you understand this repository and the distribution of its solutions.

- The file that contains Scala code solutions is: `scr`

- The path: `src/main/scala/com/DNA`

- To run the code, You should install Scala (Metals) extension in Vscode, and you can just press in `Ctrl+Shift+P`and Run the main code.

### Day1

- You can find the implementation in the file `src/main/scala/com/DNA/Day1`

***Question:***

- What happens when the user accidentally types an incorrect command?
- What happens if the user accidentally types Ctrl-c?

***Response:***

- Depending on the implementation, the system can handle incorrect commands entered by the user in various ways. One approach is to display an error message on the terminal, notifying the user that the command is not recognized, and prompting them to retry.

- When the user accidentally types Ctrl-c, which generates a keyboard interrupt signal, the system can handle it in multiple ways, depending on the implementation. A common strategy is to catch the exception generated by the signal and terminate the program in a graceful manner.

-----------
### Day2

- You can find the implementation in the file `src/main/scala/com/DNA/Day2`
  
- Since the data is stored in an append-only file, new data is always written to the end of the file, ensuring that previous data is not overwritten. This means that even if the server crashes, the data in the file will still be intact and available for recovery.

- When the server is restarted, the durable actor class will read the file and reconstruct the key-value store in memory based on the contents of the file. Any pending writes that were not yet flushed to disk at the time of the crash may be recovered using a write-ahead log (WAL), which records all pending writes to a separate file before they are written to the main data file. By replaying the WAL, the server can recover any writes that were not yet written to the main data file before the crash occurred.

- The original architecture has a worst-case time complexity of O(n) and a best-case time complexity of O(1) for a lookup operation. With the new architecture, the worst-case time complexity is still O(n) but the best-case time complexity is improved to O(1) if the key is in the in-memory store.

- For a store operation, both the original and new architectures have a time complexity of O(1), since a new key-value pair is simply appended to the end of the file and/or added to the in-memory store.

- The new architecture provides an additional level of durability, since the in-memory key-value store is periodically flushed to the file. However, there is a risk of losing some data if the server crashes before the data is flushed. To reduce this risk, you could increase the frequency of the flush operation or implement a write-ahead log (WAL) for the in-memory store, similar to the one used for the main file.
--------------
### Day3


- You can find the implementation in the file `src/main/scala/com/DNA/Day3`

