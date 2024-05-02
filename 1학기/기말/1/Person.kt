class Person {
    class Person {
        //속성 property
        private lateinit var name: String // 타입 뒤에 ?는 해당 변수에 null 허용한다.  nill-type
        // 코틀린에서는 기본 자료형은 non-null-type
        init {
            name = "리리리"
        }
        fun getName(): String {
            return name;
        }
        fun setName(name: String) {
            this.name
        }
    }
}
