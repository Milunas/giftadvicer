package milunas.giftadvice.model

data class Group(val id : String?,
                 val giftedPersonName: String,
                 val giftList: List<Gift>?,
                 val userList: List<User>?)