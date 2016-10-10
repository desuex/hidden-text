object Main extends App {
  val v = Array("\u2060", "\u200B", "\u2061", "\u2062", "\u2063", "\uFEFF", "\u200C", "\u200D")

  def str2oct(buf: Array[Byte]): String = buf.map("%03o" format _).mkString
  def oct2str(string: String): String = new String(string.sliding(3,3).toArray.map(x => BigInt(x,8).toByte))

  def voidEnc(char: String):String = v(char.toInt)
  def voidDec(char:String):String = v.indexOf(char).toString

  def char2void(string: String): String = str2oct(string.getBytes()).map(x=>voidEnc(x.toString)).mkString
  def void2char(string: String):String = oct2str(string.map(x=>voidDec(x.toString)).mkString)

  val void = char2void("Hello! Привет!")
  println(void)
  val text = void2char(void)
  println(text)
}
