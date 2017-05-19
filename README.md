# Spark-Word2Vec
Spark-Word2Vec creates vector representation of words in a text corpus. It is based on the implementation of word2vec in Spark MLlib. Several optimization techniques are used to make this algorithm more scalable and accurate.

# Highlights
  + Two models CBOW and Skip-gram are used in our implementation.
  + Both hierarchical softmax and negative sampling methods are supported to train the model.
  + The sub-sampling trick can be used to achieve both faster training and significantly better representations of uncommon words.

# Examples
## Scala API
```scala
val spark = SparkSession
  .builder
  .appName("Word2Vec example")
  .master("local[*]")
  .getOrCreate()

  // $example on$
  // Input data: Each row is a bag of words from a sentence or document.
  val documentDF = spark.createDataFrame(Seq(
    "Hi I heard about Spark".split(" "),
    "I wish Java could use case classes".split(" "),
    "Logistic regression models are neat".split(" ")
  ).map(Tuple1.apply)).toDF("text")

  // Learn a mapping from words to Vectors.
  val word2Vec = new Word2Vec()
    .setInputCol("text")
    .setOutputCol("result")
    .setVectorSize(3)
    .setMinCount(0)
  val model = word2Vec.fit(documentDF)

  val result = model.transform(documentDF)
  result.collect().foreach { case Row(text: Seq[_], features: Vector) =>
    println(s"Text: [${text.mkString(", ")}] => \nVector: $features\n") }
  // $example off$

  spark.stop()
```

# Requirements
Spark-Word2Vec is built against Spark 2.1.1.

# Build From Source
```scala
sbt package
```

# Licenses
Spark-Word2Vec is available under Apache Licenses 2.0.

# Contact & Feedback
If you encounter bugs, feel free to submit an issue or pull request. Also you can mail to:
+ hibayesian (hibayesian@gmail.com).