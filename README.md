# FreshworksAssignment

* Language used is Java.
* Tool used is Eclipse IDE 
* The whole code is written in two classes named FunctionCalls and Implementations inside the src folder.
* As the names of the classes suggests, all the functions/methods (create, read and delete) are called in the FunctionCalls class, implementation of these mehtods is done inside Implementations class.
* Properties class is used for implementing key-value pairs. Properties class being a subclass of Hashtable is used to maintain lists of values in which the key is a String and the value is also a String.
* When the code is executed, a file called data is created which has all the key-value pairs.
* To fetch the data from the file, read method can be used.( JSON object is returned )
* To insert more key-value purs, create method can be used.
* To delete a key, delete method can be used.
* For creating and deleting files, thread-safe methods like Files.createNewFile() and Files.delete() is used.
