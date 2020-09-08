'use strict';

import { BootstrapOptions } from '@angular/core/src/application_ref';

export var isLoggedIn = false;
export var jwt = "a";
export var uname = "a";

export function setUname(uname){
    this.uname = uname;
}

export function getUname(): String{
    return this.uname;
}

export function setJwt(jwt){
    this.jwt = jwt;
}

export function getJwt(): String{
    return jwt;
}

export function loggingin(){
    isLoggedIn = true;
}

export function logout(){
    isLoggedIn = false;
}

export function getStatus(): boolean{
    return isLoggedIn;
}