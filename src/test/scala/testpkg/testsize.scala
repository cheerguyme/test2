package testpkg
/**
 * Created by Christopher on 11/24/14.
 */
import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer
class testSize extends FunSuite {
  test("sizetest"){
    val trunk = Branch(Branch(Mango,Mango),Branch(Cluster(2,Mango),Cluster(1,Peach)))
    assert (trunk.size() === 5)
  }
  test ("harvest"){
    val trunk = Branch(Branch(Mango,Mango),Branch(Cluster(2,Mango),Cluster(1,Peach)))
    assert (trunk.harvest()===ArrayBuffer(Mango, Mango, Mango, Mango, Peach))
  }
  test ("grow3"){
    val trunk = Branch(Branch(Mango,Mango),Branch(Cluster(2,Mango),Cluster(1,Peach)))

    assert (trunk.grow(3).size()===15)
  }

}
