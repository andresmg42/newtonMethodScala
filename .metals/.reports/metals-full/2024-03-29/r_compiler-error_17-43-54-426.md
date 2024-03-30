file:///C:/Users/user/Desktop/cuarto%20semestre/PFC/tallere3/taller3/src/test/pruevas.worksheet.sc
### file%3A%2F%2F%2FC%3A%2FUsers%2Fuser%2FDesktop%2Fcuarto%2520semestre%2FPFC%2Ftallere3%2Ftaller3%2Fsrc%2Ftest%2Fpruevas.worksheet.sc:112: error: identifier expected but integer constant found
evaluar(Logaritmo (expr1),Atomo('x'),5. 0 )
                                        ^

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.12
Classpath:
C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\resources.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\rt.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\jsse.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\jce.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\charsets.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\jfr.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\access-bridge-64.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\cldrdata.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\dnsns.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\jaccess.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\jfxrt.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\localedata.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\nashorn.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\sunec.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\sunjce_provider.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\sunmscapi.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\sunpkcs11.jar [exists ], C:\Program Files\OpenLogic\jdk-8.0.402.06-hotspot\jre\lib\ext\zipfs.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scalameta\mdoc-runtime_2.13\2.4.0\mdoc-runtime_2.13-2.4.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\lihaoyi\fansi_2.13\0.4.0\fansi_2.13-0.4.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\lihaoyi\pprint_2.13\0.8.1\pprint_2.13-0.8.1.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-reflect\2.13.12\scala-reflect-2.13.12.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scalameta\mdoc-interfaces\2.4.0\mdoc-interfaces-2.4.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\geirsson\metaconfig-pprint_2.13\0.12.0\metaconfig-pprint_2.13-0.12.0.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file:///C:/Users/user/Desktop/cuarto%20semestre/PFC/tallere3/taller3/src/test/pruevas.worksheet.sc
text:
```scala
import scala.math._
trait Expr
case class Numero(d:Double) extends Expr
case class Atomo(x:Char) extends Expr
case class Suma(e1:Expr,e2:Expr) extends Expr
case class Prod(e1:Expr,e2:Expr) extends Expr
case class Resta(e1:Expr,e2:Expr) extends Expr
case class Div(e1:Expr,e2:Expr) extends Expr
case class Expo(e1:Expr,e2:Expr) extends Expr
case class Logaritmo(e1:Expr) extends Expr

object Numero{
    def apply(d:Double)=new Numero(d)
}

object Atomo{
    def apply(x:Char)=new Atomo(x)
}

object Suma{
    def apply(e1:Expr,e2:Expr)= new Suma(e1,e2)
}

object Prod{
    def apply(e1:Expr,e2:Expr)=new Prod(e1,e2)
}

object Resta{
    def apply(e1:Expr,e2:Expr)=new Resta(e1,e2)
}

object Div{
    def apply(e1:Expr,e2:Expr)=new Div(e1,e2)
}

object Expo{
    def apply(e1:Expr,e2:Expr)=new Expo(e1,e2)
}

object Logaritmo{
    def apply(e1:Expr)=new Logaritmo(e1) 
}

def mostrar(e:Expr):String=e match {
    case Numero(d)=>d.toString()
    case Atomo(x)=>x.toString()
    case Suma(e1,e2)=>"("+mostrar(e1)+"+"+mostrar(e2)+")"
    case Prod(e1,e2)=>"("+mostrar(e1)+"*"+mostrar(e2)+")"
    case Resta(e1,e2)=>"("+mostrar(e1)+"-"+mostrar(e2)+")"
    case Div(e1,e2)=>"("+mostrar(e1)+"/"+mostrar(e2)+")"
    case Expo(e1,e2)=>"("+mostrar(e1)+"^"+mostrar(e2)+")"
    case Logaritmo(e1)=>"(lg"+"("+mostrar(e1)+"))"
}

def derivar(f:Expr,a:Atomo):Expr = f match{
    case Numero(d)=>Numero(0)
    case Atomo(x) if x==a.x=>Numero(1)
    case Atomo(_)=>Numero(0)
    case Suma(e1,e2)=>Suma(derivar(e1,a),derivar(e2,a))
    case Resta(e1,e2)=>Resta(derivar(e1,a),derivar(e2,a))
    case Prod(e1,e2)=>Suma(Prod(derivar(e1,a),e2),Prod(e1,derivar(e2,a)))
    case Div(e1,e2)=>Div(Resta(Prod(derivar(e1,a),e2),Prod(e1,derivar(e2,a))),Expo(e2,Numero(2)))
    case Logaritmo(e1)=>Div(derivar(e1,a),e1)
    case Expo(e1,e2)=>Prod(Expo(e1,e2),Suma(Div(Prod(derivar(e1,a),e2),e1),Prod(derivar(e2,a),Logaritmo(e1))))


}

def eval(f:Expr,a:Atomo,v:Double):Double= f match {
    case Numero(d) => d
    case Atomo(x) => v
    case Suma(e1, e2) => eval(e1,a,v)+eval(e2,a,v)
    case Resta(e1, e2) => eval(e1,a,v)-eval(e2,a,v) 
    case Prod(e1, e2) => eval(e1,a,v)*eval(e2,a,v)
    case Div(e1, e2) => eval(e1,a,v)/eval(e2,a,v)
    case Expo(e1, e2) => pow(eval(e1,a,v),eval(e2,a,v))
    case Logaritmo(e1) =>log(eval(e1,a,v)) 
}






val expr1=Suma(Atomo( 'x' ) , Numero ( 2 ) )
val expr2=Prod (Atomo('x') , Atomo( 'x') )
val expr3= Suma( expr1,Expo (expr2,Numero (5)))
val expr4= Logaritmo (Atomo('x'))
val expr5=Prod ( Div ( expr1 , expr2 ) , Resta ( expr3 , expr4 ) )
val expr6=Expo (Atomo('x') , Numero (3) )

mostrar (derivar ( expr6,Atomo('x') ) )
mostrar (derivar( expr2,Atomo('x') ) )
mostrar (derivar( expr2,Atomo('y') ) )
mostrar (derivar(Suma(Atomo('K'),Prod(Numero(3.0),Atomo('x'))),Atomo('x')))

mostrar(Numero (5.0))
evaluar(Numero (5.0),Atomo('x'),1.0)
mostrar (Atomo('x'))
evaluar (Atomo('x') ,Atomo('x'),5.0)
mostrar (Suma( expr1,expr2))
evaluar(Suma(expr1,expr2),Atomo('x'),5.0)
mostrar (Prod(expr1,expr2))
evaluar (Prod(expr1,expr2),Atomo('x'),5.0)
mostrar (Resta(expr1,expr2))
evaluar( Resta (expr1,expr2),Atomo('x'),5.0)
mostrar (Div(expr1,expr2))
evaluar (Div(expr1,expr2),Atomo('x'),5.0)
mostrar (Expo (expr1,expr2))
evaluar(Expo (expr1,expr2),Atomo('x'),5.0)
mostrar(Logaritmo (expr1))
evaluar(Logaritmo (expr1),Atomo('x'),5. 0 )






// def derivar(f:Expr):String={}

// def evaluar(f:Expr,a:Atomo,v:Double):Double={}

// def limpiar(f:Expr):Expr={}

// def raizNewton(f:Expr,a:Atomo,x0:Double,ba:(Expr,Atomo,Double)=>Boolean):Double={}
```



#### Error stacktrace:

```
scala.meta.internal.parsers.Reporter.syntaxError(Reporter.scala:16)
	scala.meta.internal.parsers.Reporter.syntaxError$(Reporter.scala:16)
	scala.meta.internal.parsers.Reporter$$anon$1.syntaxError(Reporter.scala:22)
	scala.meta.internal.parsers.Reporter.syntaxError(Reporter.scala:17)
	scala.meta.internal.parsers.Reporter.syntaxError$(Reporter.scala:17)
	scala.meta.internal.parsers.Reporter$$anon$1.syntaxError(Reporter.scala:22)
	scala.meta.internal.parsers.ScalametaParser.syntaxErrorExpected(ScalametaParser.scala:421)
	scala.meta.internal.parsers.ScalametaParser.name(ScalametaParser.scala:1216)
	scala.meta.internal.parsers.ScalametaParser.termName(ScalametaParser.scala:1219)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$selector$1(ScalametaParser.scala:1276)
	scala.meta.internal.parsers.ScalametaParser.autoEndPos(ScalametaParser.scala:368)
	scala.meta.internal.parsers.ScalametaParser.selector(ScalametaParser.scala:1276)
	scala.meta.internal.parsers.ScalametaParser.simpleExprRest(ScalametaParser.scala:2329)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$simpleExpr0$3(ScalametaParser.scala:2273)
	scala.util.Success.map(Try.scala:262)
	scala.meta.internal.parsers.ScalametaParser.simpleExpr0(ScalametaParser.scala:2273)
	scala.meta.internal.parsers.ScalametaParser.simpleExpr(ScalametaParser.scala:2223)
	scala.meta.internal.parsers.ScalametaParser.prefixExpr(ScalametaParser.scala:2206)
	scala.meta.internal.parsers.ScalametaParser.postfixExpr(ScalametaParser.scala:2081)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$expr$2(ScalametaParser.scala:1676)
	scala.meta.internal.parsers.ScalametaParser.atPosOpt(ScalametaParser.scala:322)
	scala.meta.internal.parsers.ScalametaParser.autoPosOpt(ScalametaParser.scala:366)
	scala.meta.internal.parsers.ScalametaParser.expr(ScalametaParser.scala:1581)
	scala.meta.internal.parsers.ScalametaParser.argumentExpr(ScalametaParser.scala:2434)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$argumentExprsInParens$1(ScalametaParser.scala:2461)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$commaSeparated$1(ScalametaParser.scala:655)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$commaSeparated$1$adapted(ScalametaParser.scala:655)
	scala.meta.internal.parsers.ScalametaParser.iter$1(ScalametaParser.scala:645)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$tokenSeparated$1(ScalametaParser.scala:651)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$tokenSeparated$1$adapted(ScalametaParser.scala:638)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$listBy(ScalametaParser.scala:567)
	scala.meta.internal.parsers.ScalametaParser.tokenSeparated(ScalametaParser.scala:638)
	scala.meta.internal.parsers.ScalametaParser.commaSeparatedWithIndex(ScalametaParser.scala:658)
	scala.meta.internal.parsers.ScalametaParser.commaSeparated(ScalametaParser.scala:655)
	scala.meta.internal.parsers.ScalametaParser.argumentExprsInParens(ScalametaParser.scala:2461)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$scala$meta$internal$parsers$ScalametaParser$$getArgClause$2(ScalametaParser.scala:2447)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$inParensAfterOpenOr(ScalametaParser.scala:253)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$inParensOnOpenOr(ScalametaParser.scala:244)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$scala$meta$internal$parsers$ScalametaParser$$getArgClause$1(ScalametaParser.scala:2448)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:319)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:365)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$getArgClause(ScalametaParser.scala:2437)
	scala.meta.internal.parsers.ScalametaParser.simpleExprRest(ScalametaParser.scala:2344)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$simpleExpr0$3(ScalametaParser.scala:2273)
	scala.util.Success.map(Try.scala:262)
	scala.meta.internal.parsers.ScalametaParser.simpleExpr0(ScalametaParser.scala:2273)
	scala.meta.internal.parsers.ScalametaParser.simpleExpr(ScalametaParser.scala:2223)
	scala.meta.internal.parsers.ScalametaParser.prefixExpr(ScalametaParser.scala:2206)
	scala.meta.internal.parsers.ScalametaParser.postfixExpr(ScalametaParser.scala:2081)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$expr$2(ScalametaParser.scala:1676)
	scala.meta.internal.parsers.ScalametaParser.atPosOpt(ScalametaParser.scala:322)
	scala.meta.internal.parsers.ScalametaParser.autoPosOpt(ScalametaParser.scala:366)
	scala.meta.internal.parsers.ScalametaParser.expr(ScalametaParser.scala:1581)
	scala.meta.internal.parsers.ScalametaParser$$anonfun$1.$anonfun$applyOrElse$2(ScalametaParser.scala:4384)
	scala.meta.internal.parsers.ScalametaParser.stat(ScalametaParser.scala:4421)
	scala.meta.internal.parsers.ScalametaParser$$anonfun$1.applyOrElse(ScalametaParser.scala:4384)
	scala.meta.internal.parsers.ScalametaParser$$anonfun$1.applyOrElse(ScalametaParser.scala:4377)
	scala.PartialFunction.$anonfun$runWith$1(PartialFunction.scala:231)
	scala.PartialFunction.$anonfun$runWith$1$adapted(PartialFunction.scala:230)
	scala.meta.internal.parsers.ScalametaParser.statSeqBuf(ScalametaParser.scala:4440)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$batchSource$13(ScalametaParser.scala:4674)
	scala.Option.getOrElse(Option.scala:201)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$batchSource$1(ScalametaParser.scala:4674)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:319)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:365)
	scala.meta.internal.parsers.ScalametaParser.batchSource(ScalametaParser.scala:4630)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$source$1(ScalametaParser.scala:4623)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:319)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:365)
	scala.meta.internal.parsers.ScalametaParser.source(ScalametaParser.scala:4623)
	scala.meta.internal.parsers.ScalametaParser.entrypointSource(ScalametaParser.scala:4628)
	scala.meta.internal.parsers.ScalametaParser.parseSourceImpl(ScalametaParser.scala:135)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$parseSource$1(ScalametaParser.scala:132)
	scala.meta.internal.parsers.ScalametaParser.parseRuleAfterBOF(ScalametaParser.scala:59)
	scala.meta.internal.parsers.ScalametaParser.parseRule(ScalametaParser.scala:54)
	scala.meta.internal.parsers.ScalametaParser.parseSource(ScalametaParser.scala:132)
	scala.meta.parsers.Parse$.$anonfun$parseSource$1(Parse.scala:29)
	scala.meta.parsers.Parse$$anon$1.apply(Parse.scala:36)
	scala.meta.parsers.Api$XtensionParseDialectInput.parse(Api.scala:25)
	scala.meta.internal.semanticdb.scalac.ParseOps$XtensionCompilationUnitSource.toSource(ParseOps.scala:17)
	scala.meta.internal.semanticdb.scalac.TextDocumentOps$XtensionCompilationUnitDocument.toTextDocument(TextDocumentOps.scala:206)
	scala.meta.internal.pc.SemanticdbTextDocumentProvider.textDocument(SemanticdbTextDocumentProvider.scala:54)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticdbTextDocument$1(ScalaPresentationCompiler.scala:384)
```
#### Short summary: 

file%3A%2F%2F%2FC%3A%2FUsers%2Fuser%2FDesktop%2Fcuarto%2520semestre%2FPFC%2Ftallere3%2Ftaller3%2Fsrc%2Ftest%2Fpruevas.worksheet.sc:112: error: identifier expected but integer constant found
evaluar(Logaritmo (expr1),Atomo('x'),5. 0 )
                                        ^