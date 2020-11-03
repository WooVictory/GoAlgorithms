package Blog.DataClass

/**
 * created by victory_woo on 2020/10/27
 * data class 의 copy 메소드는 deep copy.
 * */
fun main(args: Array<String>){
    val person = Person("Lee")
    val copyPerson = person.copy(name = "Lee")

    println(person == copyPerson) // 값 비교.
    println(person === copyPerson) // 객체 주소값 비교.
    println(person)
    println(copyPerson)
}


data class Person(val name: String){
}
