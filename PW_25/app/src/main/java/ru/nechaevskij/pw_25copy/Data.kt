package ru.nechaevskij.pw_25copy

class Data {
    var event: String = ""
    var date: String = ""
    var time: String = ""
    var ps: String = ""

    constructor(event: String, date: String, time: String, ps: String){
        this.event = event
        this.date = date
        this.time = time
        this.ps = ps
    }
}