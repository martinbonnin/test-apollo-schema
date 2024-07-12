import kotlin.metadata.KmProperty
import kotlin.metadata.jvm.isMovedFromInterfaceCompanion
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberProperties
import kotlin.test.Test

@Target(AnnotationTarget.PROPERTY)
annotation class HiddenProperty

public class Foo {
    companion object {
        @HiddenProperty
        const val bar = "barValue"
    }
}

class MainTest {
    @Test
    fun test() {

        val prop= Foo.Companion::class.declaredMemberProperties.single()

        println("prop=" + prop.get(Foo.Companion))
    }

    fun toto(kmProperty: KmProperty) {
        kmProperty.isMovedFromInterfaceCompanion
    }
}