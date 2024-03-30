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

def evaluar(f:Expr,a:Atomo,v:Double):Double= f match {
    case Numero(d) => d
    case Atomo(x) => v
    case Suma(e1, e2) => evaluar(e1,a,v)+evaluar(e2,a,v)
    case Resta(e1, e2) => evaluar(e1,a,v)-evaluar(e2,a,v) 
    case Prod(e1, e2) => evaluar(e1,a,v)*evaluar(e2,a,v)
    case Div(e1, e2) =>(e1,e2) match{
         case (e1,Numero(0))=>throw new ArithmeticException("División por cero")
         case(Numero(0),e2)=>0
         case (e1,e2)=>evaluar(e1,a,v)/evaluar(e2,a,v)
    } 
    case Expo(e1, e2) => pow(evaluar(e1,a,v),evaluar(e2,a,v))
    case Logaritmo(e1) => evaluar(e1,a,v) match{
        case ev if (ev<=0) => throw new ArithmeticException("numero menor o igual a 0")
        case ev=>log(ev)
}
    }

def limpiar(f:Expr):Expr= f match{
    case Numero(0)=>Numero(0)
    case Numero(1)=>Numero(1)
    case Suma(e1,e2)=>(limpiar(e1),limpiar(e2)) match{
        case(Numero(0),e2l)=>e2l
        case(e1l,Numero(0))=>e1l
        case(e1l,e2l)=>Suma(e1l,e2l)
    }
    case Resta(e1,e2)=>(limpiar(e1),limpiar(e2)) match{
        case(e1l,Numero(0))=>e1l
        case(e1l,e2l)=>Resta(e1l,e2l)
    }
    case Prod(e1,e2)=>(limpiar(e1),limpiar(e2)) match{
        case(Numero(0),_)=>Numero(0)
        case(_,Numero(0))=>Numero(0)
        case(Numero(1),e2l)=>e2l
        case(e1l,Numero(1))=>e1l
        case(e1l,e2l)=>Prod(e1l,e2l)
    }
    case Div(e1,e2)=>(limpiar(e1),limpiar(e2)) match {
        case(_,Numero(0))=>throw new ArithmeticException("Divicion por cero")
        case(Numero(0),_)=>Numero(0)
        case (e1l,Numero(1))=>e1l
        case(e1l,e2l)=>Div(e1l,e2l)
    }
    case Expo(e1,e2)=>(limpiar(e1),limpiar(e2)) match{
        case(_,Numero(0))=>Numero(1)
        case(Numero(0),_)=>Numero(0)
        case(e1l,Numero(1))=>limpiar(e1l)
        case(e1l,e2l)=>Expo(e1l,e2l)
        
    }
    case Logaritmo(e1)=>limpiar(e1) match{
        case Numero(1)=>Numero(0)
        case e1l=>Logaritmo(e1l)
    }

    case f=>f
   
}

def buenaAprox ( f:Expr,a:Atomo,d:Double ):Boolean = {
evaluar(f,a,d)<0.001
}

def raizNewton(f:Expr,a:Atomo,x0:Double,ba:(Expr,Atomo,Double)=>Boolean):Double={
    if (ba(f,a,x0)) x0 
    else{
        val xi:Double= evaluar(Resta(Numero(x0),Div(f,derivar(f,a))),a,x0)
        raizNewton(f,a,xi,ba)
    } 
}

val e1=Resta(Prod(Atomo('x'),Atomo('x')),Numero(2.0))
val e2=Resta(Prod(Atomo('x'),Atomo('x')),Numero(4.0))
val e3=Suma(Resta(Prod(Atomo('x'),Atomo('x')),Numero(4.0)),Prod(Numero(3.0),Atomo('x')))

raizNewton(e1,Atomo('x'),2.0,buenaAprox)
raizNewton(e2,Atomo('x'),2.0,buenaAprox)
raizNewton(e3,Atomo('x'),2.0,buenaAprox)







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
evaluar(Logaritmo (expr1),Atomo('x'),5.0)


mostrar(derivar(Suma(Atomo('k'),Prod(Numero (3.0),Atomo('x'))),Atomo('x')))

derivar(Suma(Atomo('k'),Prod(Numero (3.0),Atomo('x'))),Atomo('x'))

limpiar(derivar(Suma(Atomo('k'),Prod (Numero (3.0),Atomo('x'))),Atomo('x')))
mostrar(limpiar(derivar(Suma(Atomo('k') ,Prod (Numero ( 3.0),Atomo('x'))),Atomo('x'))))


/*def limpiar(f: Expr): Expr = f match {
  case Numero(0) => Numero(0) // Reemplaza cero por cero
  case Numero(1) => Numero(1) // Reemplaza uno por uno
  case Suma(e1, e2) => (limpiar(e1), limpiar(e2)) match {
    case (Numero(0), e2Limpia) => e2Limpia // Si el primer término es cero, devuelve el segundo término
    case (e1Limpia, Numero(0)) => e1Limpia // Si el segundo término es cero, devuelve el primer término
    case (e1Limpia, e2Limpia) => Suma(e1Limpia, e2Limpia) // De lo contrario, mantén la suma intacta
  }
  case Resta(e1, e2) => (limpiar(e1), limpiar(e2)) match {
    case (e1Limpia, Numero(0)) => e1Limpia // Si el segundo término es cero, devuelve el primer término
    case (e1Limpia, e2Limpia) => Resta(e1Limpia, e2Limpia) // De lo contrario, mantén la resta intacta
  }
  case Prod(e1, e2) => (limpiar(e1), limpiar(e2)) match {
    case (Numero(0), _) => Numero(0) // Si uno de los términos es cero, devuelve cero
    case (_, Numero(0)) => Numero(0) // Si uno de los términos es cero, devuelve cero
    case (Numero(1), e2Limpia) => e2Limpia // Si uno de los términos es uno, devuelve el otro término
    case (e1Limpia, Numero(1)) => e1Limpia // Si uno de los términos es uno, devuelve el otro término
    case (e1Limpia, e2Limpia) => Prod(e1Limpia, e2Limpia) // De lo contrario, mantén el producto intacto
  }
  case Div(e1, e2) => (limpiar(e1), limpiar(e2)) match {
    case (_, Numero(0)) => throw new ArithmeticException("División por cero") // Si el divisor es cero, lanza una excepción
    case (Numero(0), _) => Numero(0) // Si el dividendo es cero, devuelve cero
    case (e1Limpia, Numero(1)) => e1Limpia // Si el divisor es uno, devuelve el dividendo
    case (e1Limpia, e2Limpia) => Div(e1Limpia, e2Limpia) // De lo contrario, mantén la división intacta
  }
  case Expo(e1, e2) => (limpiar(e1), limpiar(e2)) match {
    case (_, Numero(0)) => Numero(1) // Cualquier número elevado a cero es uno
    case (Numero(0), _) => Numero(0) // Cero elevado a cualquier número es cero
    case (_, Numero(1)) => limpiar(e1) // Cualquier número elevado a uno es el número mismo
    case (e1Limpia, e2Limpia) => Expo(e1Limpia, e2Limpia) // De lo contrario, mantén la exponenciación intacta
  }
  case Logaritmo(e1) => limpiar(e1) match {
    case Numero(1) => Numero(0) // El logaritmo de uno en cualquier base es cero
    case e1Limpia => Logaritmo(e1Limpia) // De lo contrario, mantén el logaritmo intacto
  }
  case e => e // En cualquier otro caso, devolver la expresión sin cambios
}*/




