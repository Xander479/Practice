ORG $008C81
db $FC,$FC,$FC,$FC,$FC,$FC,$FC,$FC		; Removes the top of the item box

ORG $008CF7
db $FC,$FC,$FC,$FC,$FC,$FC,$FC,$FC		; Removes the bottom of the item box

ORG $008E06
db $FC,$FC,$FC,$FC,$FC,$FC,$FC,$FC,$FC,$FC	;\ Removes bonus star
db $FC,$FC,$FC,$FC,$FC,$FC,$FC,$FC,$FC,$FC	;/ numbers from the HUD

ORG $008EE3
NOP						;\ Makes the HUD treat your score as if it's 0
NOP						;/

ORG $008EEB
CPX.B #$07					; Overwrites the units column of the score with a space too

ORG $008F49
LDA.B #$FC					;\ 
STA.W $0F15					;/ Gets rid of the X in front of your lives
LDX.B #$FC					;\ 
STX.W $0F16					; | Overwrites lives digits with spaces
STX.W $0F17					;/
STX.W $0EF9					;\ 
STX.W $0EFA					; | I tried to use a loop for this but it didn't work properly
STX.W $0EFB					; | So instead we're stuck with this ugliness, but hey! It works.
STX.W $0EFC					; | Oh yeah, it removes "MARIO" from the HUD
STX.W $0EFD					;/
STX.W $0F1B					;\ Removes the * X next to your bonus stars counter
STX.W $0F1C					;/
STX.W $0F10					;\ Removes the coin icon...
STX.W $0F11					;/ ... and the X next to it
STX.W $0F05					;\ 
STX.W $0F08					; | Removes the sides of the item box
STX.W $0F20					; |
STX.W $0F23					;/
NOP						;\ 
NOP						; | Deletes unneeded code
NOP						; |
NOP						;/
NOP						;\ Makes the HUD treat your coins as < 10
NOP						;/
LDX.B #$FC					;\ 
STX.W $0F14					; | Overwrites the coins digits with spaces
STX.W $0F13					;/

ORG $008FC5
NOP						;\ 
NOP						; | Removes your reserve item from the HUD (still works though)
NOP						;/
