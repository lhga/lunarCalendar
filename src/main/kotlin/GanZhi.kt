import java.time.LocalDate

/*


推算天干：
公元后任何年代：公元年末位数-3=年干，负数则加10
公元前任何年代：公元年末位数+8=年干
（公式揭密：因为公元3年为癸亥年，而天干又是逢10一循环。公元4年天干是甲，而4-3=1。由于没有公元0年，所以公元前的天干为末位数-3+1，再+10转为正数）
推算地支：
公元后任何年代：（公元年数-3）÷12，得余数0-11为年支，负数则加12，0视做12
公元前任何年代：（公元年数-2）÷12，余数-11-0为年支，加12转为正数，0视做12
（公式揭密：类似前述）
另：
⒈公元年末二位数+9÷12=得余数为年支(适用于1800—1899 年)；
⒉ 公元年末二位数十1÷12=得余数为年支(适用于1900—1999 年)；
⒊公元年末二位数+5÷12=得余数为年支(适用于即2000—2099 年)；
说明：
注：年干支是以立春为界，而不是以春节为界的。如1964年阳历2月4日的阴历为十二月二十一，仍为癸卯年；但1964年阳历2月5日的阴历虽为十二月二十二，而此日已立春，宜做甲辰年。
例一：求公元前7的年柱干支：年干=-7+8=1，即甲；年支=（-7-2）÷12=-9，加12转为正数3，即寅。故公元前7年是甲寅年。
例二：求2000年的年柱干支 ：年干=末位数0-3=-3，加10=7，即庚。 年支=00+5=5，即辰。 故2000年是庚辰年。
例三：求1999年的年柱干支 ：年干=末位数9-3=6，即己；年支=末二位数99+1=100减去8个12后余4，即卯。故1999年是己卯年。
注：我们所说的某个阳历年份对应的阴历干支，是该年大部分时间与其对应，而不是完全重合的。

 */
val ganList: CharSequence = "甲乙丙丁戊己庚辛壬癸"
val zhiList : CharSequence = "子丑寅卯辰巳午未申酉戌亥"
fun getGanZhi(day: LocalDate): String {
    //excludes 公元前
    // not counting days before 立春
    if(day.year<4)
        return "Only supports year 0004 and after."
    val t = (day.year-3-1)% 10
    val d = (day.year-3-1)% 12
    return ""+ganList[t] + zhiList[d]


}
fun main(){
    println(getGanZhi(LocalDate.parse("2022-04-28")))
    ganList.forEach { println(it) }
    zhiList.forEach { println(it) }
}