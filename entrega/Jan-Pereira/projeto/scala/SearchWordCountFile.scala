val rdd =  sc.wholeTextFiles("file:///home/cloudera/Desktop/Pos/Binhara/books").cache()

val files = rdd.map { case (filename, content) => filename}

files.collect.foreach( file => {
val word = "make"
val rdd2 = sc.textFile(file);
val wordFoundCount = rdd2.flatMap(str => str.split(" ")).filter(text => text.contains(word)).map(word => (word, 1)).reduceByKey(_+_).collect().mkString(" ");
println("Word, total: %s => file %s".format(wordFoundCount,file));
})
