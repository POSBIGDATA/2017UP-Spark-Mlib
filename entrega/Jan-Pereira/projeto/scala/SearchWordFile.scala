val rdd = sc.wholeTextFiles("file:///home/cloudera/Desktop/Pos/Binhara/books").cache()

val files = rdd.map { case (filename, content) => filename}

files.collect.foreach( file => {
val word = "make"
val rdd2 = sc.textFile(file);
val wordFound = rdd2.flatMap(str => str.split(" ")).filter(text => text.contains(word)).collect().mkString(" ");
println("Word: %s => file %s".format(wordFound,file));
})

