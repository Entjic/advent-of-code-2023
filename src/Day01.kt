fun main() {
    fun part1(input: List<String>): Int {
        var counter = 0;
        input.forEach { string ->
            // string.println();
            var first = 'a';
            var last = 'b';

            for (c in string.toCharArray()) {
                if (c.isDigit()) {
                    if (first == 'a') {
                        first = c;
                    }
                    last = c;
                }
            }
            var result = ("" + first + last).toInt();
            counter += result;
        }
        return counter;
    }

    fun String.addCharAtIndex(char: Char, index: Int) =
            StringBuilder(this).apply { insert(index, char) }.toString()

    fun replace(input: String, index: Int): String {
        var subString = input.substring(index);

        if (subString.startsWith("one")) {
            return input.addCharAtIndex('1', index)
        }
        if (subString.startsWith("two")) {
            return input.addCharAtIndex('2', index)
        }
        if (subString.startsWith("three")) {
            return input.addCharAtIndex('3', index)
        }
        if (subString.startsWith("four")) {
            return input.addCharAtIndex('4', index)
        }
        if (subString.startsWith("five")) {
            return input.addCharAtIndex('5', index)
        }
        if (subString.startsWith("six")) {
            return input.addCharAtIndex('6', index)
        }
        if (subString.startsWith("seven")) {
            return input.addCharAtIndex('7', index)
        }
        if (subString.startsWith("eight")) {
            return input.addCharAtIndex('8', index)
        }
        if (subString.startsWith("nine")) {
            return input.addCharAtIndex('9', index)
        }

        return input;

    }

    fun generateLastIndexList(string : String): List<Int>{
        val one = string.lastIndexOf("one");
        val two = string.lastIndexOf("two");
        val three = string.lastIndexOf("three");
        val four = string.lastIndexOf("four");
        val five = string.lastIndexOf("five");
        val six = string.lastIndexOf("six");
        val seven = string.lastIndexOf("seven");
        val eight = string.lastIndexOf("eight");
        val nine = string.lastIndexOf("nine");

        return listOf(one, two, three, four, five, six, seven, eight, nine)
                .filter { i -> i != -1 };
    }

    fun generateFirstIndexList(string: String): List<Int> {
        val one = string.indexOf("one");
        val two = string.indexOf("two");
        val three = string.indexOf("three");
        val four = string.indexOf("four");
        val five = string.indexOf("five");
        val six = string.indexOf("six");
        val seven = string.indexOf("seven");
        val eight = string.indexOf("eight");
        val nine = string.indexOf("nine");

        return listOf(one, two, three, four, five, six, seven, eight, nine)
                .filter { i -> i != -1 };
    }

    fun convert(input: String): String {
        var string = input;
        string.println()
        var list = generateFirstIndexList(string);
        val min = list.minOrNull() ?: return string;
        min.println()
        string = replace(string, min);
        list = generateLastIndexList(string)
        val max = list.maxOrNull() ?: return string;
        if(max == min + 1) return string;
        max.println()
        string = replace(string, max);
        string.println()
        return string;
    }

    fun part2(input: List<String>): Int {
        return part1(input.map { it ->
            // it.println()
            convert(it);
        });
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    // check(part2(testInput) == 33)

    val input = readInput("Day01")
    // part1(input).println()
    part2(input).println()
}
