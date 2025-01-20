fun main(){
    val animales = listOf("Perro", "Gato", "Conejo", "Oso", "Tigre", "Jirafa", "Elefante", "Mono", "Cebra")
    println("Bienvenido al juego del ahorcado: ")
    val palabra = animales.random().lowercase()
    val estadoPalabra = MutableList(palabra.length) { '*' }
    var intentos = 7
    println("Adivina el animal. Tienes $intentos intentos")
    println(estadoPalabra.joinToString(""))

    while (intentos>0){
        println("Introduce una letra: ")
        val letra = readln()

        if (palabra.contains(letra)){
            println("Correcto! La letra $letra está en la palabra")
            for (i in palabra.indices) {
                if (palabra[i].toString() == letra) {
                    estadoPalabra[i] = letra[0]
                }
            }
        } else{
            println("La letra $letra no está en la palabra")
            intentos--
            if (intentos==0) {
                println("Has agotado todos tus intentos")
                break
            }
        }



        println("Adivina el animal. Tienes $intentos intentos")
        println(estadoPalabra.joinToString(""))

        if (!estadoPalabra.contains('*')){
            println("Felicidades! Has acertado la palabra")
            break
        }
    }
}