fun main(){
    val musica = "pugnodollari.mid"
    val reproductor = ReproductorMidi(musica)
    val animales = listOf("Perro", "Gato", "Conejo", "Oso", "Tigre", "Jirafa", "Elefante", "Mono", "Cebra")
    println("Bienvenido al juego del ahorcado: ")
    val palabra = animales.random().lowercase()
    val estadoPalabra = MutableList(palabra.length){'*'}
    var intentos = 0
    println("Adivina el animal. Te quedan 7 intentos")
    println(estadoPalabra.joinToString(""))

    while (intentos<7){
        println("Introduce una letra: ")
        val letra = readln()

        if (letra.length > 1 || letra.isEmpty()){
            println("El valor introducido es incorrecto")
            continue
        }
        if (letra in palabra){
            println("Correcto! La letra $letra está en la palabra")
            for (i in palabra.indices) {
                if (palabra[i].toString() == letra) {
                    estadoPalabra[i] = letra[0]
                }
            }
        } else{
            intentos++
            val dibujo=DibujoAhorcado.dibujar(intentos)
            println(dibujo)
            println("La letra $letra no está en la palabra")
            if (intentos==7) {
                println("Has agotado todos tus intentos")
                break
            }
        }

        if (('*') !in estadoPalabra){
            println("Felicidades! Has acertado la palabra")
            break
        }

        println("Adivina el animal. Tienes " + (7-intentos) + " intentos")
        println(estadoPalabra.joinToString(""))
    }
    reproductor.cerrar()
}