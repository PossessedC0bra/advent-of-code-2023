import kotlin.io.path.Path
import kotlin.io.path.readLines

fun readInput(relativePath: String) = Path("src/main/resources/${relativePath}").readLines();