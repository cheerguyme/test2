package testpkg

/**
 * Created by Christopher on 11/23/14.
 */



object Main extends App{
  var trunk = Branch(Branch(Mango,Mango),Branch(Cluster(2,Mango),Cluster(1,Peach)))
  println(trunk.size())
  var basket = trunk.harvest()
  basket.foreach(println(_))

  println((trunk.grow(3).grow(3)).size())
}

