import com.android.buildsrc.dependencies.*
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.applibraries() {

    androidX()
    DaggerHilt()
    glide()
    gson()
    gander()
    materialDesign()
    NavGraph()
    okHttp()
    retrofit()
    vmLifeCycle()
    androidPaging()
    testUnit()
    coroutine()
    lottie()
    googleFirebase()
    dodenhof()
    room()
}