import com.tsovedenski.csp.*
import com.tsovedenski.csp.heuristics.pruning.schemas.PartialLookAhead
import com.tsovedenski.csp.strategies.Backtracking
import com.tsovedenski.csp.wordsum.WordSum
import org.junit.Assert
import org.junit.Test

/**
 * Created by Tsvetan Ovedenski on 14/10/18.
 */
class SendMoreMoneyTest {

    @Test
    fun `SEND + MORE = MONEY`() {
        val task = WordSum("SEND", "MORE", "MONEY")
        val solution = task.solve(strategy = Backtracking(
            pruneSchema = PartialLookAhead()
        ))

        Assert.assertNotNull(solution)
        solution as Solved

        val expectedAssignment = emptyAssignment<Char, Int>().apply {
            this['M'] = Selected(1)
            this['O'] = Selected(0)
            this['N'] = Selected(6)
            this['E'] = Selected(5)
            this['Y'] = Selected(2)
            this['S'] = Selected(9)
            this['D'] = Selected(7)
            this['R'] = Selected(8)
        }.toCompleteAssignment()!!

        Assert.assertEquals(expectedAssignment, solution.assignment)
    }
}