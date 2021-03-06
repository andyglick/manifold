package manifold.api.gen;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class SrcSwitchStatement extends SrcStatement<SrcSwitchStatement>
{
  private SrcExpression _expr;
  private List<SrcSwitchCase> _cases = new ArrayList<>();
  private SrcStatement _default;

  public SrcSwitchStatement expr( SrcExpression expr )
  {
    _expr = expr;
    return this;
  }

  public SrcSwitchStatement defaultCase( SrcStatement defaultStmt )
  {
    _default = defaultStmt;
    return this;
  }

  public SrcSwitchStatement addCase( SrcSwitchCase aCase )
  {
    _cases.add( aCase );
    return this;
  }

  public StringBuilder render( StringBuilder sb, int indent )
  {
    return render( sb, indent, false );
  }

  public StringBuilder render( StringBuilder sb, int indent, boolean sameLine )
  {
    indent( sb, indent );
    sb.append( "switch(" ).append( _expr ).append( ") { \n" );
    for( SrcSwitchCase caseStmt : _cases )
    {
      caseStmt.render( sb, indent + INDENT );
    }
    if( _default != null )
    {
      indent( sb, indent + INDENT );
      sb.append( "default:\n" );
      if( _default instanceof SrcStatementBlock )
      {
        ((SrcStatementBlock)_default).render( sb, indent, false );
      }
      else
      {
        _default.render( sb, indent + INDENT );
      }
    }
    sb.append( indent( sb, indent ) ).append( "}\n" );
    return sb;
  }
}
