module ParTAD where

class Par s where
    firts :: s -> Integer
    second :: s  -> Integer 
    suma :: s  -> s  -> s 
    mult :: s  -> s -> s 