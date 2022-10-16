module PolyTAD where

class Poly s where
    eval :: Integer -> s -> Integer
    suma :: s -> s -> s  
    mult :: s -> s -> s 