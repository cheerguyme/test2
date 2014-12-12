package testpkg

/**
 * Created by Christopher on 11/19/14.
 */


trait Tree {
  def size(): Int
  def grow(factor: Int): Tree
  def harvest(): Seq[Fruit]
}

trait Fruit extends Tree {
  override def size(): Int = 1
  override def grow(factor: Int): Tree = Cluster(factor,this)
  override def harvest(): Seq[Fruit] = Seq(this)
}

case object Mango extends Fruit
case object Peach extends Fruit

case class Branch(children: Tree*) extends Tree {
  override def size(): Int = children.map(_.size()).sum
  override def grow(factor: Int): Tree = Cluster(factor,this)
  override def harvest(): Seq[Fruit] = children.flatMap(_.harvest())
}

case class Cluster(howmany: Int, child: Tree) extends Tree {
  override def size(): Int = child.size()*howmany
  override def grow(factor: Int): Tree = Cluster(howmany*factor,child)
  override def harvest(): Seq[Fruit] = (for(i<-1 to howmany) yield {child}).flatMap(_.harvest())
}