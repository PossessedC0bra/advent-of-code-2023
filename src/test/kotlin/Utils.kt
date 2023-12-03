import kotlin.io.path.Path
import kotlin.io.path.readLines

fun readTestInput(relativePath: String) = Path("src/test/resources/${relativePath}").readLines()