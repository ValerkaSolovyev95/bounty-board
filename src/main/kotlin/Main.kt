const val HERO_NAME = "Madrigal"
var playerLevel = 5

fun main() {
    println("$HERO_NAME announces her presence to the world.")
    println(HERO_NAME)
    readBountyBoard()
    println("Time passes...")
    println("The hero returns from her quest.")
    playerLevel += 1
    println(playerLevel)
    readBountyBoard()

}

private fun readBountyBoard() {
    println("The hero approaches the bounty board. It reads:")
    println(obtainQuest(playerLevel))
}

private fun obtainQuest(
    playerLevel: Int,
    playerClass: String = "paladin",
    harBefriendedBarbarian: Boolean = true,
    hasAngeredBarbarian: Boolean = false
): String = when (playerLevel) {
    1 -> "Meet Mr. Bubbles in the land of soft things"
    in 2..5 -> {
        val canTalkToBarbarians = !hasAngeredBarbarian &&
                (harBefriendedBarbarian || playerClass == "barbarian")
        if (canTalkToBarbarians) {
            "Convince the barbarians to call off their invasion"
        } else {
            "Save town from barbarian invasion"
        }
    }

    6 -> "Locate the enchanted sword."
    7 -> "Recover the long-lost artifact of creation"
    8 -> "Defeat Nogartse, bringer of death and eater of worlds"
    else -> "There note quests right now"
}