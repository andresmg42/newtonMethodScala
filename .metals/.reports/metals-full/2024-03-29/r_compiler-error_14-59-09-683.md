file:///C:/Users/user/Desktop/cuarto%20semestre/PFC/tallere3/taller3/src/test/pruevas.worksheet.sc
### file%3A%2F%2F%2FC%3A%2FUsers%2Fuser%2FDesktop%2Fcuarto%2520semestre%2FPFC%2Ftallere3%2Ftaller3%2Fsrc%2Ftest%2Fpruevas.worksheet.sc:61: error: illegal start of simple pattern
}
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
    def apply(n:Double)=new Numero(n)
}

object Atomo{
    def apply(x:Char)=new Atomo(x)
}

object Suma{
    def apply(e1:Expr,e2:Expr)= new Suma(e1,e2)
}

object Prod{
    def apply(e1:Expr,e2:Expr)=new Prod(e2,e2)
}

object Resta{
    def apply(e1:Expr,e2:Expr)=new Resta(e2,e2)
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
    case Numero(n)=>n.toString()
    case Atomo(n)=>n.toString()
    case Suma(e1,e2)=>"("+mostrar(e1)+"+"+mostrar(e2)+")"
    case Prod(e1,e2)=>"("+mostrar(e1)+"*"+mostrar(e2)+")"
    case Resta(e1,e2)=>"("+mostrar(e1)+"-"+mostrar(e2)+")"
    case Div(e1,e2)=>"("+mostrar(e1)+"/"+mostrar(e2)+")"
    case Expo(e1,e2)=>"("+mostrar(e1)+"^"+mostrar(e2)+")"
    case Logaritmo(e1)=>"(lg"+"("+mostrar(e1)+"))"
}

def derivar(f:Expr,a:Atomo):Expr = f match{
    case Numero(n)=>Numero(n)
    case Atomo(n)=>Numero(1)
    case Suma(e1,e2)=>derivar(e1)+derivar(e2)
    case Resta(e1,e2)=>derivar(e1)-derivar(e2)
    case 

}



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
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.badPattern3(ScalametaParser.scala:2785)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.badPattern3$(ScalametaParser.scala:2765)
	scala.meta.internal.parsers.ScalametaParser$noSeq$.badPattern3(ScalametaParser.scala:2884)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.$anonfun$pattern3$1(ScalametaParser.scala:2743)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.$anonfun$simplePattern$2(ScalametaParser.scala:2871)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:319)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:365)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.simplePattern(ScalametaParser.scala:2796)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.simplePattern$(ScalametaParser.scala:2791)
	scala.meta.internal.parsers.ScalametaParser$noSeq$.simplePattern(ScalametaParser.scala:2884)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern3(ScalametaParser.scala:2743)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern3$(ScalametaParser.scala:2741)
	scala.meta.internal.parsers.ScalametaParser$noSeq$.pattern3(ScalametaParser.scala:2884)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern2(ScalametaParser.scala:2718)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern2$(ScalametaParser.scala:2717)
	scala.meta.internal.parsers.ScalametaParser$noSeq$.pattern2(ScalametaParser.scala:2884)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern1(ScalametaParser.scala:2693)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern1$(ScalametaParser.scala:2692)
	scala.meta.internal.parsers.ScalametaParser$noSeq$.pattern1(ScalametaParser.scala:2884)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.patternAlternatives(ScalametaParser.scala:2646)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern(ScalametaParser.scala:2642)
	scala.meta.internal.parsers.ScalametaParser$SeqContextSensitive.pattern$(ScalametaParser.scala:2642)
	scala.meta.internal.parsers.ScalametaParser$noSeq$.pattern(ScalametaParser.scala:2884)
	scala.meta.internal.parsers.ScalametaParser.pattern(ScalametaParser.scala:2902)
	scala.meta.internal.parsers.ScalametaParser.caseClause(ScalametaParser.scala:2520)
	scala.meta.internal.parsers.ScalametaParser.iter$4(ScalametaParser.scala:2551)
	scala.meta.internal.parsers.ScalametaParser.caseClausesIfAny(ScalametaParser.scala:2558)
	scala.meta.internal.parsers.ScalametaParser.caseClauses(ScalametaParser.scala:2534)
	scala.meta.internal.parsers.ScalametaParser.matchClause(ScalametaParser.scala:1525)
	scala.meta.internal.parsers.ScalametaParser.iter$2(ScalametaParser.scala:1723)
	scala.meta.internal.parsers.ScalametaParser.exprOtherRest(ScalametaParser.scala:1728)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$expr$2(ScalametaParser.scala:1677)
	scala.meta.internal.parsers.ScalametaParser.atPosOpt(ScalametaParser.scala:322)
	scala.meta.internal.parsers.ScalametaParser.autoPosOpt(ScalametaParser.scala:366)
	scala.meta.internal.parsers.ScalametaParser.expr(ScalametaParser.scala:1581)
	scala.meta.internal.parsers.ScalametaParser.expr(ScalametaParser.scala:1480)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$funDefRest$1(ScalametaParser.scala:3807)
	scala.meta.internal.parsers.ScalametaParser.autoEndPos(ScalametaParser.scala:368)
	scala.meta.internal.parsers.ScalametaParser.autoEndPos(ScalametaParser.scala:373)
	scala.meta.internal.parsers.ScalametaParser.funDefRest(ScalametaParser.scala:3769)
	scala.meta.internal.parsers.ScalametaParser.funDefOrDclOrExtensionOrSecondaryCtor(ScalametaParser.scala:3714)
	scala.meta.internal.parsers.ScalametaParser.defOrDclOrSecondaryCtor(ScalametaParser.scala:3544)
	scala.meta.internal.parsers.ScalametaParser.nonLocalDefOrDcl(ScalametaParser.scala:3523)
	scala.meta.internal.parsers.ScalametaParser$$anonfun$1.applyOrElse(ScalametaParser.scala:4382)
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

file%3A%2F%2F%2FC%3A%2FUsers%2Fuser%2FDesktop%2Fcuarto%2520semestre%2FPFC%2Ftallere3%2Ftaller3%2Fsrc%2Ftest%2Fpruevas.worksheet.sc:61: error: illegal start of simple pattern
}
^