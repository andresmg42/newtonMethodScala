file:///C:/Users/user/Desktop/cuarto%20semestre/PFC/tallere3/taller3/src/test/pruevas.worksheet.sc
### file%3A%2F%2F%2FC%3A%2FUsers%2Fuser%2FDesktop%2Fcuarto%2520semestre%2FPFC%2Ftallere3%2Ftaller3%2Fsrc%2Ftest%2Fpruevas.worksheet.sc:74: error: illegal character '\u2019'
mostrar (derivar ( expr6 , Atomo( ’ x ’ ) ) )
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
    case Numero(n)=>n.toString()
    case Atomo(x)=>x.toString()
    case Suma(e1,e2)=>"("+mostrar(e1)+"+"+mostrar(e2)+")"
    case Prod(e1,e2)=>"("+mostrar(e1)+"*"+mostrar(e2)+")"
    case Resta(e1,e2)=>"("+mostrar(e1)+"-"+mostrar(e2)+")"
    case Div(e1,e2)=>"("+mostrar(e1)+"/"+mostrar(e2)+")"
    case Expo(e1,e2)=>"("+mostrar(e1)+"^"+mostrar(e2)+")"
    case Logaritmo(e1)=>"(lg"+"("+mostrar(e1)+"))"
}

def derivar(f:Expr,a:Atomo):Expr = f match{
    case Numero(n)=>Numero(0)
    case Atomo(x) if x==a.x=>Numero(1)
    case Atomo(_)=>Numero(0)
    case Suma(e1,e2)=>Suma(derivar(e1,a),derivar(e2,a))
    case Resta(e1,e2)=>Resta(derivar(e1,a),derivar(e2,a))
    case Prod(e1,e2)=>Suma(Prod(derivar(e1,a),e2),Prod(e2,derivar(e2,a)))
    case Div(e1,e2)=>Div(Resta(Prod(derivar(e1,a),e2),Prod(e1,derivar(e2,a))),Expo(e2,Numero(2)))
    case Logaritmo(e1)=>Div(derivar(e1,a),e1)
    case Expo(e1,e2)=>Prod(Expo(e1,e2),Suma(Div(Prod(derivar(e1,a),e2),e1),Prod(derivar(e2,a),Logaritmo(e1))))


}
val expr1=Suma(Atomo( 'x' ) , Numero ( 2 ) )
val expr2=Prod (Atomo('x') , Atomo( 'x') )
val expr3= Suma( expr1,Expo (expr2,Numero (5)))
val expr4= Logaritmo (Atomo('x'))
val expr5=Prod ( Div ( expr1 , expr2 ) , Resta ( expr3 , expr4 ) )
val expr6=Expo (Atomo('x') , Numero (3) )

mostrar (derivar ( expr6 , Atomo( ’ x ’ ) ) )
mostrar (derivar( expr2 , Atomo( ’ x ’ ) ) )
mostrar (derivar( expr2 , Atomo( ’ y ’ ) ) )
mostrar (derivar(Suma(Atomo('K'),Prod (Numero (3.0), Atomo( ’ x ’ ) ) ) , Atomo( ’ x ’ ) ) )





// def derivar(f:Expr):String={}

// def evaluar(f:Expr,a:Atomo,v:Double):Double={}

// def limpiar(f:Expr):Expr={}

// def raizNewton(f:Expr,a:Atomo,x0:Double,ba:(Expr,Atomo,Double)=>Boolean):Double={}
```



#### Error stacktrace:

```
scala.meta.internal.tokenizers.Reporter.syntaxError(Reporter.scala:23)
	scala.meta.internal.tokenizers.Reporter.syntaxError$(Reporter.scala:23)
	scala.meta.internal.tokenizers.Reporter$$anon$1.syntaxError(Reporter.scala:33)
	scala.meta.internal.tokenizers.Reporter.syntaxError(Reporter.scala:25)
	scala.meta.internal.tokenizers.Reporter.syntaxError$(Reporter.scala:25)
	scala.meta.internal.tokenizers.Reporter$$anon$1.syntaxError(Reporter.scala:33)
	scala.meta.internal.tokenizers.LegacyScanner.fetchOther$1(LegacyScanner.scala:469)
	scala.meta.internal.tokenizers.LegacyScanner.fetchToken(LegacyScanner.scala:474)
	scala.meta.internal.tokenizers.LegacyScanner.nextToken(LegacyScanner.scala:211)
	scala.meta.internal.tokenizers.LegacyScanner.foreach(LegacyScanner.scala:1011)
	scala.meta.internal.tokenizers.ScalametaTokenizer.uncachedTokenize(ScalametaTokenizer.scala:24)
	scala.meta.internal.tokenizers.ScalametaTokenizer.$anonfun$tokenize$1(ScalametaTokenizer.scala:17)
	scala.collection.concurrent.TrieMap.getOrElseUpdate(TrieMap.scala:962)
	scala.meta.internal.tokenizers.ScalametaTokenizer.tokenize(ScalametaTokenizer.scala:17)
	scala.meta.internal.tokenizers.ScalametaTokenizer$$anon$2.apply(ScalametaTokenizer.scala:332)
	scala.meta.tokenizers.Api$XtensionTokenizeDialectInput.tokenize(Api.scala:25)
	scala.meta.tokenizers.Api$XtensionTokenizeInputLike.tokenize(Api.scala:14)
	scala.meta.internal.parsers.ScannerTokens$.apply(ScannerTokens.scala:953)
	scala.meta.internal.parsers.ScalametaParser.<init>(ScalametaParser.scala:33)
	scala.meta.parsers.Parse$$anon$1.apply(Parse.scala:35)
	scala.meta.parsers.Api$XtensionParseDialectInput.parse(Api.scala:25)
	scala.meta.internal.semanticdb.scalac.ParseOps$XtensionCompilationUnitSource.toSource(ParseOps.scala:17)
	scala.meta.internal.semanticdb.scalac.TextDocumentOps$XtensionCompilationUnitDocument.toTextDocument(TextDocumentOps.scala:206)
	scala.meta.internal.pc.SemanticdbTextDocumentProvider.textDocument(SemanticdbTextDocumentProvider.scala:54)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticdbTextDocument$1(ScalaPresentationCompiler.scala:384)
```
#### Short summary: 

file%3A%2F%2F%2FC%3A%2FUsers%2Fuser%2FDesktop%2Fcuarto%2520semestre%2FPFC%2Ftallere3%2Ftaller3%2Fsrc%2Ftest%2Fpruevas.worksheet.sc:74: error: illegal character '\u2019'
mostrar (derivar ( expr6 , Atomo( ’ x ’ ) ) )
                                  ^