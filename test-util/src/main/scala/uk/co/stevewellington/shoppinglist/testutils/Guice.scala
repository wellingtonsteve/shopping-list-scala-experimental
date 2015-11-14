package uk.co.stevewellington.shoppinglist.testutils

import com.google.inject.Injector

import scala.reflect.Manifest

trait Guice {
  def get[T <: AnyRef](implicit manifest: Manifest[T]): FromInjector[T] = {
    new FromInjector[T](manifest.runtimeClass.asInstanceOf[Class[T]])
  }

  class FromInjector[T <: AnyRef](clazz: Class[T]) {
    def from(injector: Injector): T = injector.getInstance(clazz)
  }

}