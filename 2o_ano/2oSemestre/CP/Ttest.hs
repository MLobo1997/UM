module Ttest where

data T = Nil | Cons (Int , T) deriving Show

outT :: T -> Either () (Int, T)
outT Nil = Left ()
outT (Cons (a, t)) = Right (a,t)

inT :: Either () (Int,T) -> T
inT t = either (noArg Nil) Cons t

noArg :: (a) -> b -> a
noArg f a = f

