import Cp

data Atl
data Jog
data Dat

f1 :: [(Dat, [Jog])] -> [(Jog,[Atl])] -> [(Atl,[Dat])]
f1 = undefined

collect ::[(a,b)] -> [(a,[b])]
collect = undefined

discollect ::[(a,[b])] -> [(a,b)]
discollect = undefined

converse ::[(a,b)] -> [(b,a)]
converse = undefined

comp :: [(a,b)] -> [(b,c)] -> [(a,c)]
comp = undefined

sort :: [a] -> [a]
sort = undefined
