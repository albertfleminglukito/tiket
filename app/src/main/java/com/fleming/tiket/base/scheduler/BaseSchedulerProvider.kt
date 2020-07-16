package com.fleming.tiket.base.scheduler

import io.reactivex.Scheduler


interface BaseSchedulerProvider {

	fun computation(): Scheduler

	fun io(): Scheduler

	fun ui(): Scheduler

}
