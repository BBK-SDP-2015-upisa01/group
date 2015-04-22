import akka.actor.Actor
// TODO
//
// Make this an actor and write a message handler for at least the
// set method.
//

case class setMessage(x: Int, y: Int, c: Colour)

class Coordinator extends Actor{

  def receive = {
    case setMessage(x,y,c) => Coordinator.set(x, y, c)
  }
}

object Coordinator {
  def init(im: Image, of: String) = {
    image = im
    outfile = of
    waiting = im.width * im.height
  }

  // Number of pixels we're waiting for to be set.
  var waiting = 0
  var outfile: String = null
  var image: Image = null

  // TODO: make set a message
  def set(x: Int, y: Int, c: Colour) = {
    image(x, y) = c
    waiting -= 1
  }

  def print = {
    assert(waiting == 0)
    image.print(outfile)
  }
}
