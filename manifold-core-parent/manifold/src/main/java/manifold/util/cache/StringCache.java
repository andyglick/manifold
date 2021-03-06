package manifold.util.cache;

public class StringCache
{
  public static String get( String rawString )
  {
    if( rawString == null )
    {
      return null;
    }
    return StringPool.get( rawString );
  }
}
