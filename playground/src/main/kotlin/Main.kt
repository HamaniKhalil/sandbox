import kotlin.reflect.typeOf

@Target(allowedTargets = [AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS])
annotation class Payload

abstract class Template<@Payload P> {

    abstract fun preProcess(payload: P)
    abstract fun postProcess(payload: P)

    fun execute(payload: P) {
        preProcess(payload)
        postProcess(payload)
    }

}

class OperationA : Template<Data>() {

    override fun preProcess(payload: Data) {
        payload.name = "Operated - ${payload.name}"
    }

    override fun postProcess(payload: Data) {
        payload.age += 2
    }

}

//@Payload
data class Data(
    var name: String = "John Doe",
    var age: Int = 20,
)


fun main() {

    val data = Data()

    val operationA = OperationA()

    operationA.execute(data)

    println(data)


    println("0.".toDoubleOrNull())

}