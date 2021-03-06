package manifold.api.fs;

import java.net.URL;

public interface IProtocolAdapter
{
  String[] getSupportedProtocols();

  IDirectory getIDirectory( URL url );

  IFile getIFile( URL url );
}
