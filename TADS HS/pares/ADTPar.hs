module ADTpar where
import ParTAD

data ParInt = Integer :/ Integer
 
instance Show ParInt where
    show (p :/ q) = "(" ++ (show p) ++ "," ++ (show q) ++ ")"

instance Par ParInt where
    firts (p :/ q) = p
    second (p :/ q) = q
    suma (p :/ q) (n :/ m) = ( (p+n) :/ (m+q))
    mult (p :/ q) (n :/ m) = ((p*n) :/ (m*q))
