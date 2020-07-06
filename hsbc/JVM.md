![jvm](./img/1.PNG)

![jvm](./img/2.PNG)

![jvm](./img/3.PNG)
STACK

Each time call java method or function will push data into java STACK

Heap

store application required memeory other than STACK

in java application there is only one heap share
across all threads and number of stacks, one stack for each threads

Object are stored on the heap
Variables are reference to the Object
Local variables are stored on the stack

![jvm](./img/4.PNG)

![jvm](./img/5.PNG)

![jvm](./img/6.PNG)

GC ###https://www.youtube.com/watch?v=UnaNQgzw4zY&t=733s

#![gc](./img/gc1.PNG) #![gc](./img/gc2.PNG) #![gc](./img/gc3.PNG) ##![gc](./img/gc4.PNG) #![gc](./img/gc5.PNG)
![gc](./img/gc6.PNG)
![gc](./img/gc7.PNG)
![gc](./img/gc8.PNG)
![gc](./img/gc9.PNG)
![gc](./img/gc10.PNG)
![gc](./img/gc11.PNG)
![gc](./img/gc12.PNG)
![gc](./img/gc13.PNG)
![gc](./img/gc14.PNG)
![gc](./img/gc15.PNG)
![gc](./img/gc16.PNG)
![gc](./img/gc17.PNG)
![gc](./img/gc18.PNG)
![gc](./img/gc19.PNG)
![gc](./img/gc20.PNG)

What is Heap-Offloading ?
https://code.google.com/archive/p/fast-serialization/wikis/QuickStartHeapOff.wiki

Usually all non-temporary objects you allocate are managed by java's garbage collector.
Although the VM does a decent job doing garbage collection, at a certain point the VM has to do a so called 'Full GC'.
A full GC involves scanning the complete allocated Heap, which means GC pauses/slowdowns are proportional to an applications heap size.
So don't trust any person telling you 'Memory is Cheap'. In java memory consumtion hurts performance.
Additionally you may get notable pauses using heap sizes > 1 Gb. This can be nasty if you have any near-real-time stuff going on,
in a cluster or grid a java process might get unresponsive and get dropped from the cluster.

However todays server applications (frequently built on top of bloaty frameworks ;-) ) easily require heaps far beyond 4Gb.

One solution to these memory requirements, is to 'offload' parts of the objects to the non-java heap
(directly allocated from the OS). Fortunately java.nio provides classes to directly allocate/read and write 'unmanaged' chunks of memory (even memory mapped files).

So one can allocate large amounts of 'unmanaged' memory and use this to save objects there. In order to save arbitrary objects into unmanaged memory,
the most viable solution is the use of Serialization. This means the application serializes objects into the offheap memory,
later on the object can be read using deserialization.

The heap size managed by the java VM can be kept small, so GC pauses are in the millis, everybody is happy, job done.

It is clear, that the performance of such an off heap buffer depends mostly on the performance of the serialization implementation.
Good news: for some reason FST-serialization is pretty fast :-).

Sample usage scenarios:

Session cache in a server application. Use a memory mapped file to store gigabytes of (inactive) user sessions.
Once the user logs into your application, you can quickly access user-related data without having to deal with a database.

Caching of computational results (queries, html pages, ..) (only applicable if computation is slower than deserializing the result object ofc).

very simple and fast persistance using memory mapped files

Edit: For some scenarios one might choose more sophisticated Garbage Collection algorithms such as ConcurrentMarkAndSweep
or G1 to support larger heaps (but this also has its limits beyond 16GB heaps).
There is also a commercial JVM with improved 'pauseless' GC (Azul) available.
