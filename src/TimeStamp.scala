/**
 * Created by Jo on 20/01/2015.
 */
class TimeStamp(val seconds: Long)

object TimeStamp{
  def apply(hours: Int, minutes: Int, seconds: Int) =
    new TimeStamp(hours*60*60 + minutes *60 + seconds)
}
