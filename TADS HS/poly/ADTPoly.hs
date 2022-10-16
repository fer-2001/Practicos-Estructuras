module ADTPoly where
import PolyTAD

data Polynomio = Integer :/ Integer deriving Show
 
--instance Show ParInt where
--    show (p :/ q) = "(" ++ (show p) ++ "," ++ (show q) ++ ")"

instance Poly Polynomio where
    eval x (p :/ q) = (x^p)*q 
    suma (p :/ q) (n :/ m) = ( (p+n) :/ (m+q))
    mult (p :/ q) (n :/ m) = ((p*n) :/ (m*q))
