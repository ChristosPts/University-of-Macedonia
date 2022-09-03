library IEEE;
use IEEE.std_logic_1164.all;

-- Create full subtractor
entity Subtractor1_flow is
    port (X,Y,Z: in bit ;
          D,bout: out bit);
end Subtractor1_flow;

architecture dataflow of Subtractor1_flow is
begin
    D <= X xor Y xor Z;
    bout <= (not (X) and Z) or (not (X) and Y) or (Y and Z);
end dataflow;

-- Create 4bit subtractor 
entity Subtractor4bit is port (
    A, B: in bit_vector (3 downto 0); -- Δήλωση αριθμών για αφαίρεση
    diff: out bit_vector (3 downto 0);  -- Η διαφορά των αριθμών
    borrow: inout bit_vector(4 downto 0)); -- δάνεισμα κάθε αφαιρέτη
end Subtractor4bit;
-- Using Subtractor1_flow to create the 4 bit subtractor
architecture structure of Subtractor4bit is
component Subtractor1_flow
     port (X,Y,Z: in bit ;
     D,bout: out bit);
end component;

begin
  g0: for index in 0 to 3 generate
    u0: Subtractor1_flow port map (
    X=> A(index), Y=> B(index), D=> diff(index), Z=> borrow(index),
    bout=> borrow (index+1));
  end generate;
end structure;
