-- Code your testbench here
library IEEE;
use IEEE.std_logic_1164.all;

entity test_encoder8x3 is
end test_encoder8x3;

architecture testbench of test_encoder8x3 is

component encoder8x3
port(d0,d1,d2,d3,d4,d5,d6,d7: in bit; x,y,z: out bit);
end component;

signal tb_d0:bit; signal tb_d1:bit;
signal tb_d2:bit; signal tb_d3:bit;
signal tb_d4:bit; signal tb_d5:bit;
signal tb_d6:bit; signal tb_d7:bit;
signal tb_x:bit; signal tb_y:bit; signal tb_z:bit;

begin
u0: encoder8x3 port map(
d0 => tb_d0, d1 => tb_d1, d2 => tb_d2, d3 => tb_d3,
d4 => tb_d4, d5 => tb_d5, d6 => tb_d6, d7 => tb_d7,
x => tb_x, y => tb_y, z => tb_z);

process
begin
--input: 00000001 -> output:000
tb_d0 <= '1'; tb_d1 <= '0';
tb_d2 <= '0'; tb_d3 <= '0';
tb_d4 <= '0'; tb_d5 <= '0';
tb_d6 <= '0'; tb_d7 <= '0';
wait for 10 ns;

--input: 00000010 -> output:001
tb_d0 <= '0'; tb_d1 <= '1';
tb_d2 <= '0'; tb_d3 <= '0';
tb_d4 <= '0'; tb_d5 <= '0';
tb_d6 <= '0'; tb_d7 <= '0';
wait for 10 ns;

--input: 00000100 -> output:010
tb_d0 <= '0'; tb_d1 <= '0';
tb_d2 <= '1'; tb_d3 <= '0';
tb_d4 <= '0'; tb_d5 <= '0';
tb_d6 <= '0'; tb_d7 <= '0';
wait for 10 ns;

--input: 00001000 -> output:011
tb_d0 <= '0'; tb_d1 <= '0';
tb_d2 <= '0'; tb_d3 <= '1';
tb_d4 <= '0'; tb_d5 <= '0';
tb_d6 <= '0'; tb_d7 <= '0';
wait for 10 ns;

--input: 00010000 -> output:100
tb_d0 <= '0'; tb_d1 <= '0';
tb_d2 <= '0'; tb_d3 <= '0';
tb_d4 <= '1'; tb_d5 <= '0';
tb_d6 <= '0'; tb_d7 <= '0';
wait for 10 ns;

--input: 00100000 -> output:101
tb_d0 <= '0'; tb_d1 <= '0';
tb_d2 <= '0'; tb_d3 <= '0';
tb_d4 <= '0'; tb_d5 <= '1';
tb_d6 <= '0'; tb_d7 <= '0';
wait for 10 ns;

--input: 01000000 -> output:110
tb_d0 <= '0'; tb_d1 <= '0';
tb_d2 <= '0'; tb_d3 <= '0';
tb_d4 <= '0'; tb_d5 <= '0';
tb_d6 <= '1'; tb_d7 <= '0';
wait for 10 ns;

--input: 10000000 -> output:111
tb_d0 <= '0'; tb_d1 <= '0';
tb_d2 <= '0'; tb_d3 <= '0';
tb_d4 <= '0'; tb_d5 <= '0';
tb_d6 <= '0'; tb_d7 <= '1';
wait for 10 ns;

end process;
end testbench;
