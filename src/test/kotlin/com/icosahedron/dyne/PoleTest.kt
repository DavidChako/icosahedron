package com.icosahedron.dyne

import com.icosahedron.common.Tetray
import kotlin.test.Test

class PoleTest {
    @Test fun `monte carlo pole evolution in absence of force`() {
//        val originEvent = Event(Tetray(10, 10, 10, 10), Tetray(10, 10, 10, 10))
//        val endpointEvent = Event(Tetray(20, 10, 10, 0), Tetray(10, 10, 10, 10))
        val originEvent = Event(Tetray(1, 1, 1, 1), Tetray(1, 1, 1, 1))
        val endpointEvent = Event(Tetray(2, 1, 1, 0), Tetray(1, 1, 1, 1))

        val pole = Pole(originEvent, endpointEvent)
        val runCount = 1000000000
        val stepCount = 1
        val monteCarlo = PoleMonteCarlo(pole, runCount, stepCount)
        monteCarlo.run()
    }
}

//final class ExploreSpec extends Specification {
//    def "explore"() {
//        given:
//        int[] initialAnchorLocation = [ 10, 10, 10, 10 ]
//        int[] initialAnchorInertia = [ 10, 10, 10, 10 ]
//        Actor anchor = new Actor(initialAnchorLocation, initialAnchorInertia)
//
//        int[] initialMastLocation = [ 20, 10, 10, 0 ]
//        int[] initialMastInertia = [ 10, 10, 10, 10 ]
//        Actor mast = new Actor(initialMastLocation, initialMastInertia)
//
//        Pole pole = new Pole(anchor, mast)
//        int runCount = 1000000
//        int stepCount = 20
//        OldScenario scenario = new OldScenario(
//            pole,
//            runCount,
//            stepCount
//        )
//        int randomSeed = 0
//        def random = new Random(randomSeed)
//
//        when:
//        scenario.run()
//
//        then:
//        scenario.printDistanceByTime(System.out)
//    }
//}

//0 --> [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1000000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//1 --> [0, 0, 0, 0, 0, 0, 0, 0, 0, 72589, 510567, 416844, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//2 --> [0, 0, 0, 0, 0, 0, 0, 0, 4393, 90567, 388028, 407456, 109556, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//3 --> [0, 0, 0, 0, 0, 0, 0, 214, 9637, 100983, 328740, 377989, 160432, 22005, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//4 --> [0, 0, 0, 0, 0, 0, 9, 758, 15124, 106694, 294680, 350119, 185817, 43301, 3498, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//5 --> [0, 0, 0, 0, 0, 2, 40, 1552, 20205, 110330, 272214, 327270, 198445, 60470, 8971, 501, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//6 --> [0, 0, 0, 0, 0, 4, 116, 2535, 24502, 112310, 256735, 309965, 203653, 73989, 14650, 1471, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//7 --> [0, 0, 0, 0, 0, 12, 217, 3608, 28526, 113038, 244925, 296521, 205823, 83901, 20370, 2849, 203, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//8 --> [0, 0, 0, 0, 0, 20, 359, 4733, 31444, 114476, 235703, 284898, 206483, 91918, 25128, 4380, 437, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//9 --> [0, 0, 0, 0, 1, 25, 512, 5859, 34314, 115112, 228163, 275422, 206516, 97637, 29894, 5751, 742, 51, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//10 --> [0, 0, 0, 0, 1, 39, 694, 6832, 36885, 115923, 221479, 268206, 205365, 102120, 33980, 7305, 1070, 94, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//11 --> [0, 0, 0, 0, 2, 53, 944, 7935, 38849, 116354, 217638, 260610, 204349, 105867, 36827, 8971, 1424, 165, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//12 --> [0, 0, 0, 0, 1, 81, 1089, 8926, 40826, 116609, 212948, 255816, 203361, 108459, 39562, 10222, 1846, 232, 21, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//13 --> [0, 0, 0, 0, 8, 112, 1363, 9649, 42330, 117230, 209814, 250731, 201761, 110977, 41983, 11427, 2281, 305, 26, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//14 --> [0, 0, 0, 0, 7, 169, 1585, 10562, 43866, 117539, 206326, 246627, 201073, 112260, 44400, 12549, 2584, 412, 39, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//15 --> [0, 0, 0, 0, 10, 188, 1857, 11381, 44993, 117498, 204598, 242770, 199569, 113762, 46433, 13473, 2935, 468, 61, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//16 --> [0, 0, 0, 0, 14, 230, 1983, 12238, 45968, 117977, 202317, 240092, 198098, 114983, 47493, 14719, 3238, 573, 70, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//17 --> [0, 0, 0, 0, 14, 261, 2187, 12870, 47163, 118059, 200937, 237287, 196857, 115494, 49146, 15397, 3605, 632, 79, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//18 --> [0, 0, 0, 0, 29, 256, 2444, 13352, 48521, 117810, 199844, 234867, 195487, 116276, 50289, 16195, 3806, 709, 106, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//19 --> [0, 0, 0, 1, 28, 321, 2553, 14081, 49225, 118205, 198079, 233305, 194059, 117291, 51190, 16684, 4071, 776, 119, 10, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//20 --> [0, 0, 0, 4, 31, 354, 2743, 14630, 49859, 118310, 197320, 231073, 193520, 117846, 51840, 17197, 4288, 856, 114, 14, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

