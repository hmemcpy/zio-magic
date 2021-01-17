package zio

import zio.magic.macros._

package object magic {
  import scala.language.experimental.macros

  final class BuildMagicLayer[Out <: Has[_]]() {
    def apply[In1, Out1, In2, Out2](
        layer1: URLayer[In1, Out1],
        layer2: URLayer[In2, Out2]
    )(implicit dummyK: DummyK[Out]): ULayer[Out] =
      macro ProvideMagicLayerMacros.makeLayerImpl[In1, Out1, In2, Out2, Out]
  }

  implicit final class ZLayerSingletonOps(val self: ZLayer.type) extends AnyVal {
    def fromMagic[Out <: Has[_]] = new BuildMagicLayer[Out]
  }

  def makeAMagicLayer[In1, Out1, In2, Out2, Out <: Has[_]](
      layer1: URLayer[In1, Out1],
      layer2: URLayer[In2, Out2]
  )(implicit dummyK: DummyK[Out]): ULayer[Out] =
    macro ProvideMagicLayerMacros.makeLayerImpl[In1, Out1, In2, Out2, Out]

  implicit final class ZioProvideSomeMagicOps[Require](val zio: ZIO[Require, Nothing, Unit]) extends AnyVal {
    def provideSomeMagicLayer[Provide, Remainder <: Require](
        zlayer: ZLayer[Any, Nothing, Provide]
    )(implicit dummyK: DummyK[Require]): ZIO[Remainder, Nothing, Unit] =
      macro ProvideSomeMagicMacro.provideSomeMagicImpl[Require, Provide, Remainder]
  }

  implicit final class ZioProvideMagicOps[Final, A](val zio: ZIO[Final, Nothing, A]) extends AnyVal {

    def provideMagicLayer()(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer0Impl[Final, A]

    def provideMagicLayer[In1, Out1](
        layer1: ZLayer[In1, Nothing, Out1]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer1Impl[In1, Out1, Final, A]

    def provideMagicLayer[In1, Out1, In2, Out2](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer2Impl[In1, Out1, In2, Out2, Final, A]

    def provideMagicLayer[In1, Out1, In2, Out2, In3, Out3](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer3Impl[In1, Out1, In2, Out2, In3, Out3, Final, A]

    def provideMagicLayer[In1, Out1, In2, Out2, In3, Out3, In4, Out4](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer4Impl[In1, Out1, In2, Out2, In3, Out3, In4, Out4, Final, A]

    def provideMagicLayer[In1, Out1, In2, Out2, In3, Out3, In4, Out4, In5, Out5](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros
        .provideMagicLayer5Impl[In1, Out1, In2, Out2, In3, Out3, In4, Out4, In5, Out5, Final, A]

    def provideMagicLayer[In1, Out1, In2, Out2, In3, Out3, In4, Out4, In5, Out5, In6, Out6](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros
        .provideMagicLayer6Impl[In1, Out1, In2, Out2, In3, Out3, In4, Out4, In5, Out5, In6, Out6, Final, A]

    def provideMagicLayer[In1, Out1, In2, Out2, In3, Out3, In4, Out4, In5, Out5, In6, Out6, In7, Out7](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros
        .provideMagicLayer7Impl[In1, Out1, In2, Out2, In3, Out3, In4, Out4, In5, Out5, In6, Out6, In7, Out7, Final, A]

    def provideMagicLayer[In1, Out1, In2, Out2, In3, Out3, In4, Out4, In5, Out5, In6, Out6, In7, Out7, In8, Out8](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer8Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer9Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer10Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer11Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer12Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12],
        layer13: ZLayer[In13, Nothing, Out13]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer13Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12],
        layer13: ZLayer[In13, Nothing, Out13],
        layer14: ZLayer[In14, Nothing, Out14]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer14Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12],
        layer13: ZLayer[In13, Nothing, Out13],
        layer14: ZLayer[In14, Nothing, Out14],
        layer15: ZLayer[In15, Nothing, Out15]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer15Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12],
        layer13: ZLayer[In13, Nothing, Out13],
        layer14: ZLayer[In14, Nothing, Out14],
        layer15: ZLayer[In15, Nothing, Out15],
        layer16: ZLayer[In16, Nothing, Out16]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer16Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12],
        layer13: ZLayer[In13, Nothing, Out13],
        layer14: ZLayer[In14, Nothing, Out14],
        layer15: ZLayer[In15, Nothing, Out15],
        layer16: ZLayer[In16, Nothing, Out16],
        layer17: ZLayer[In17, Nothing, Out17]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer17Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        In18,
        Out18
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12],
        layer13: ZLayer[In13, Nothing, Out13],
        layer14: ZLayer[In14, Nothing, Out14],
        layer15: ZLayer[In15, Nothing, Out15],
        layer16: ZLayer[In16, Nothing, Out16],
        layer17: ZLayer[In17, Nothing, Out17],
        layer18: ZLayer[In18, Nothing, Out18]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer18Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        In18,
        Out18,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        In18,
        Out18,
        In19,
        Out19
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12],
        layer13: ZLayer[In13, Nothing, Out13],
        layer14: ZLayer[In14, Nothing, Out14],
        layer15: ZLayer[In15, Nothing, Out15],
        layer16: ZLayer[In16, Nothing, Out16],
        layer17: ZLayer[In17, Nothing, Out17],
        layer18: ZLayer[In18, Nothing, Out18],
        layer19: ZLayer[In19, Nothing, Out19]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer19Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        In18,
        Out18,
        In19,
        Out19,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        In18,
        Out18,
        In19,
        Out19,
        In20,
        Out20
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12],
        layer13: ZLayer[In13, Nothing, Out13],
        layer14: ZLayer[In14, Nothing, Out14],
        layer15: ZLayer[In15, Nothing, Out15],
        layer16: ZLayer[In16, Nothing, Out16],
        layer17: ZLayer[In17, Nothing, Out17],
        layer18: ZLayer[In18, Nothing, Out18],
        layer19: ZLayer[In19, Nothing, Out19],
        layer20: ZLayer[In20, Nothing, Out20]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer20Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        In18,
        Out18,
        In19,
        Out19,
        In20,
        Out20,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        In18,
        Out18,
        In19,
        Out19,
        In20,
        Out20,
        In21,
        Out21
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12],
        layer13: ZLayer[In13, Nothing, Out13],
        layer14: ZLayer[In14, Nothing, Out14],
        layer15: ZLayer[In15, Nothing, Out15],
        layer16: ZLayer[In16, Nothing, Out16],
        layer17: ZLayer[In17, Nothing, Out17],
        layer18: ZLayer[In18, Nothing, Out18],
        layer19: ZLayer[In19, Nothing, Out19],
        layer20: ZLayer[In20, Nothing, Out20],
        layer21: ZLayer[In21, Nothing, Out21]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer21Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        In18,
        Out18,
        In19,
        Out19,
        In20,
        Out20,
        In21,
        Out21,
        Final,
        A
      ]

    def provideMagicLayer[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        In18,
        Out18,
        In19,
        Out19,
        In20,
        Out20,
        In21,
        Out21,
        In22,
        Out22
    ](
        layer1: ZLayer[In1, Nothing, Out1],
        layer2: ZLayer[In2, Nothing, Out2],
        layer3: ZLayer[In3, Nothing, Out3],
        layer4: ZLayer[In4, Nothing, Out4],
        layer5: ZLayer[In5, Nothing, Out5],
        layer6: ZLayer[In6, Nothing, Out6],
        layer7: ZLayer[In7, Nothing, Out7],
        layer8: ZLayer[In8, Nothing, Out8],
        layer9: ZLayer[In9, Nothing, Out9],
        layer10: ZLayer[In10, Nothing, Out10],
        layer11: ZLayer[In11, Nothing, Out11],
        layer12: ZLayer[In12, Nothing, Out12],
        layer13: ZLayer[In13, Nothing, Out13],
        layer14: ZLayer[In14, Nothing, Out14],
        layer15: ZLayer[In15, Nothing, Out15],
        layer16: ZLayer[In16, Nothing, Out16],
        layer17: ZLayer[In17, Nothing, Out17],
        layer18: ZLayer[In18, Nothing, Out18],
        layer19: ZLayer[In19, Nothing, Out19],
        layer20: ZLayer[In20, Nothing, Out20],
        layer21: ZLayer[In21, Nothing, Out21],
        layer22: ZLayer[In22, Nothing, Out22]
    )(implicit dummyK: DummyK[Final]): ZIO[Any, Nothing, A] =
      macro ProvideMagicLayerMacros.provideMagicLayer22Impl[
        In1,
        Out1,
        In2,
        Out2,
        In3,
        Out3,
        In4,
        Out4,
        In5,
        Out5,
        In6,
        Out6,
        In7,
        Out7,
        In8,
        Out8,
        In9,
        Out9,
        In10,
        Out10,
        In11,
        Out11,
        In12,
        Out12,
        In13,
        Out13,
        In14,
        Out14,
        In15,
        Out15,
        In16,
        Out16,
        In17,
        Out17,
        In18,
        Out18,
        In19,
        Out19,
        In20,
        Out20,
        In21,
        Out21,
        In22,
        Out22,
        Final,
        A
      ]

  }

}
