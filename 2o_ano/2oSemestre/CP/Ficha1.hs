module Ficha1 where

import Data.Maybe

data LTree a = Leaf a | Fork (LTree a , LTree a)

mylength :: [a] -> Int
mylength [] = 0
mylength (h:t) = 1 + mylength t

myreverse :: [a] -> [a]
myreverse (h:t) = aux [h] t
    where 
          aux l [] = l
          aux l (h:t) = aux (h:l) t

mycatMaybes :: [Maybe a] -> [a]
mycatMaybes [] = []
mycatMaybes ((Just a) : t) = a : mycatMaybes t
mycatMaybes (h:t) = mycatMaybes t

uncurry :: (a -> b -> c) -> (a,b) -> c
uncurry f (a,b) =  f a b  

curry :: ((a,b) -> c) -> a -> b -> c
curry f a b = f (a,b)

flip :: (a -> b -> c) -> b -> a -> c
flip f b a = f a b

flatten :: LTree a  -> [a]
flatten (Leaf a) = [a]
flatten (Fork (l,r)) = flatten l ++ flatten r

mirror :: LTree a -> LTree a
mirror (Leaf a) = Leaf a
mirror (Fork (l,r)) = Fork(mirror r, mirror l)

myfmap :: (a -> b) -> LTree a -> LTree b
myfmap f (Leaf a) = Leaf (f a)
myfmap f (Fork (l,r)) = Fork(myfmap f l , myfmap f r)

mylength2 :: [a] -> Int
mylength2 l = foldr (\x y -> succ y) 0 l
