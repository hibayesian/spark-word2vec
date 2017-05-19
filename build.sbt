name := "spark-word2vec"

version := "1.0"

scalaVersion := "2.11.8"

spName := "hibayesian/spark-word2vec"

sparkVersion := "2.1.1"

sparkComponents += "mllib"

resolvers += Resolver.sonatypeRepo("public")

spShortDescription := "spark-word2vec"

spDescription := """A parallel implementation of word2vec based on Spark"""
  .stripMargin

credentials += Credentials(Path.userHome / ".ivy2" / ".sbtcredentials")

licenses += "Apache-2.0" -> url("http://opensource.org/licenses/Apache-2.0")